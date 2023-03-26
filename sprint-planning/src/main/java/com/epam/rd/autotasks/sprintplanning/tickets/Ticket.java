package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    protected final int id;
    protected final String name;
    protected final int estimate;

    protected boolean isComplete = false;
    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.isComplete;
    }

    public void complete() {
        this.isComplete = true;
    }

    public int getEstimate() {
        return this.estimate;
    }
}
