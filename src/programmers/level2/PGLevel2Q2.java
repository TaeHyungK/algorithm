package programmers.level2;


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
public class PGLevel2Q2 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] splitSkill = skill.split("");
        for (String skill_tree : skill_trees) {
            String replaceSkillTree = replaceSkillTree(splitSkill, skill_tree);

            if (replaceSkillTree.length() == skill.length()) {
                if (skill.equals(replaceSkillTree)) {
                    answer ++;
                }
            } else if (replaceSkillTree.length() < skill.length()) {
                String tempSkill = skill.substring(0, replaceSkillTree.length());
                if (tempSkill.equals(replaceSkillTree)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * skill_tree 중 skill을 제외한 String 제거
     * @param skill_tree skill_tree
     *
     * @return skill String만 남긴 값
     */
    private static String replaceSkillTree(String[] splitSkill, String skill_tree) {
        String replaceSkill = "";

        String[] splitSkillTree = skill_tree.split("");

        for (String curSkillTree : splitSkillTree) {
            for (String curSkill : splitSkill) {
                if (curSkill.equals(curSkillTree)) {
                    replaceSkill += curSkill;
                }
            }
        }


        return replaceSkill;
    }
}
