package Pojos.HerOkuPojo;

import java.util.List;

public class Gmi_Name_State_pojo {


        private  String name;
        private List<GmiPojo>  state;

        public Gmi_Name_State_pojo() {
        }

        public Gmi_Name_State_pojo(String name, List<GmiPojo> state) {
                this.name = name;
                this.state = state;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public List<GmiPojo> getState() {
                return state;
        }

        public void setState(List<GmiPojo> state) {
                this.state = state;
        }

        @Override
        public String toString() {
                return "Gmi_Name_State_pojo{" +
                        "name='" + name + '\'' +
                        ", state=" + state +
                        '}';
        }
}
