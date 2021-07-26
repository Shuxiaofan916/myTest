package com.company.controller;
import java.util.ArrayList;
import java.util.List;

public class PlanChange {
    public static void main(String[] args) {
        Task t1 = new Task(600,true);
        Task t2 = new Task(200,false);
        Task t3 = new Task(200,false);
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        int sum=0;
        for(Task t:tasks){
            sum+=t.getNumber();
        }
        PlanChange planChange = new PlanChange();

        //分配数量大于已完成情况
        List<Task> AfterTasks2 = planChange.changePlan(sum, 400, tasks);
        for(Task t:AfterTasks2){
            System.out.println(t.toString());
        }
        //剩余分配的机器大于材料数
        List<Task> AfterTasks3 = planChange.changePlan(sum, 1, tasks);
        for(Task t:AfterTasks3){
            System.out.println(t.toString());
        }
        //可通过情况
        List<Task> AfterTasks = planChange.changePlan(sum, 2000, tasks);
        for(Task t:AfterTasks){
            System.out.println(t.toString());
        }


    }
    public List<Task> changePlan(Integer planNum,Integer changeNum,List<Task> list){
        //尚还需要完成的数量
        int needNum=changeNum;
        //后续计算未完成任务占比的剩余任务比例
        int proportionNum=planNum;
        //算未完成机器的数量
        int falseNum=list.size();
        //如果修改后的计划单小于已完成的任务数量则抛出异常
        for(Task t:list){
            if(t.getState()==true){
                proportionNum-=t.getNumber();
                needNum-=t.getNumber();
                falseNum--;
            }

            if(needNum<0){
                //抛出异常 返回原来的list 不做修改
                System.out.println("重新分配的总数量小于已完成的数量:");
                return list;
            }
        }
        //此时有false状态任务单数量 和 仍然需要加工的数量
        //如果任务的单数比机器数量还多 则会出现任务单为0的情况
        if(needNum<falseNum){
            //条件2
            System.out.println("剩余的分配数量小于机器:");
            return list;
        }
        //此时needNum为仍然需要完成的数量
        for(Task t:list){
            double afterDNum=0;
            if (t.getState()==false){
                //按照原来的比例返回对应的数量
                //类型转换
                afterDNum=(double)needNum*t.getNumber()/proportionNum;
                int afterINum = new Double(afterDNum).intValue();
                //保底机制
                if(afterINum==0){
                    afterINum++;
                }
                t.setNumber(afterINum);
            }
        }
        System.out.println("修改成功:");
        return list;
    }


    static class Task{
        //任务数
        private int number;
        //完成状态
        private Boolean state;

        public Task() {
        }

        public Task(int number, Boolean state) {
            this.number = number;
            this.state = state;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Boolean getState() {
            return state;
        }

        public void setState(Boolean state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "number=" + number +
                    ", state=" + state +
                    '}';
        }
    }

}
