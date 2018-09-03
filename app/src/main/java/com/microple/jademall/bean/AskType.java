package com.microple.jademall.bean;

import java.util.List;

/**
 * author: xiaoguagnfei
 * date: 2018/9/3
 * describe:
 */
public class AskType {

    private List<ProblemTypeBean> problem_type;

    public List<ProblemTypeBean> getProblem_type() {
        return problem_type;
    }

    public void setProblem_type(List<ProblemTypeBean> problem_type) {
        this.problem_type = problem_type;
    }

    public static class ProblemTypeBean {
        /**
         * pt_id : 1
         * type : 提现
         */

        private int pt_id;
        private String type;

        public int getPt_id() {
            return pt_id;
        }

        public void setPt_id(int pt_id) {
            this.pt_id = pt_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
