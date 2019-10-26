package programmers.level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문제 설명
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 * <p>
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고,
 * 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 * <p>
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
 * 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만,
 * 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 * <p>
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
 * 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 * <p>
 * 제한 조건
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 * <p>
 * 입출력 예
 * skill	skill_trees	return
 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 * <p>
 * 입출력 예 설명
 * BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
 * CBADF: 가능한 스킬트리입니다.
 * AECB: 가능한 스킬트리입니다.
 * BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
 */

/**
 * TODO 해당 문제를 정규식 표현으로 풀어보려 했으나 쉽지 않아 실패했다.
 *      다른 방법을 생각해 보거나 정규 표현식을 다시 생각해 봐야 한다.
 */
public class PGLevel2Q2UseMatch {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_tree = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_tree));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Pattern[] patterns = makePattern(skill);

        for (String curSkill : skill_trees) {
            System.out.println(curSkill);
            for (int i = patterns.length - 1; i > 0; i--) {
                if (i == 0) continue; // 한글자짜리 패턴은 소용이 없으므로 continue 처리
                Matcher m = patterns[i].matcher(curSkill);
                if (m.find()) {
                    answer++;
                    break; // 한번 match 됐을 경우 중단 처리
                }
            }
        }

        return answer;
    }

    private static Pattern[] makePattern(String skill) {
        Pattern[] patterns = new Pattern[skill.length()];
        String[] skillSplit = skill.split("");

        String temp = "";
        for (int i = 0; i < skillSplit.length; i++) {
            temp += skillSplit[i];
            String patternString = "(\\w?)";

            String[] tempSplit = temp.split("");
            for (String tempSplitItem : tempSplit) {
                patternString += tempSplitItem + "(\\w?)";
            }
            Pattern pattern = Pattern.compile(patternString);
            patterns[i] = pattern;
        }

        return patterns;
    }
}
