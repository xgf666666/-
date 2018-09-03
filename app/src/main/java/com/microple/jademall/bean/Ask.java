package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class Ask {

    private List<ProblemBean> problem;

    public List<ProblemBean> getProblem() {
        return problem;
    }

    public void setProblem(List<ProblemBean> problem) {
        this.problem = problem;
    }

    public static class ProblemBean {
        /**
         * pb_id : 1
         * problem : 为什么提现失败
         */

        private int pb_id;
        private String problem;

        public int getPb_id() {
            return pb_id;
        }

        public void setPb_id(int pb_id) {
            this.pb_id = pb_id;
        }

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }
    }
}
