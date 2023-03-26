package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {

    protected final UserStory[] dependsOn;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        for (UserStory dependency : dependsOn){
            if (!dependency.isCompleted()){
                return;
            }
        }

        this.isComplete = true;
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(this.dependsOn, this.dependsOn.length);
    }

    @Override
    public String toString() {
        return "[US "+this.getId() +"] "+this.getName();
    }


}
