package com.microple.jademall.bean;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class AskDetail {

    /**
     * problem : {"answer":"如果你无法简洁的表达你的想法，那只能说明你还不够了解它"}
     */

    private ProblemBean problem;

    public ProblemBean getProblem() {
        return problem;
    }

    public void setProblem(ProblemBean problem) {
        this.problem = problem;
    }

    public static class ProblemBean {
        /**
         * answer : 如果你无法简洁的表达你的想法，那只能说明你还不够了解它
         */

        private String answer;

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
