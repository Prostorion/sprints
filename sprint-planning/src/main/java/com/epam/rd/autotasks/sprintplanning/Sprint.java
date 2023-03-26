package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {

    private final int capacity;
    private int totalEstimate = 0;
    private int numOfTickets = 0;
    private final int ticketsLimit;

    private Ticket[] tickets;
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    private void addTicket(Ticket ticket){
        this.tickets[this.numOfTickets] = ticket;
        this.numOfTickets++;
        this.totalEstimate+= ticket.getEstimate();
    }
    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || numOfTickets>=ticketsLimit
                || totalEstimate+ userStory.getEstimate()>capacity
                || userStory.isCompleted()){
            return false;
        }
        else{
            for (var story:userStory.getDependencies()) {
                boolean flag = false;
                for (var ticket: this.tickets) {
                    if (ticket == story){
                        flag =true;
                    }
                }
                if (!flag){
                    return false;
                }
            }
            this.addTicket(userStory);
            return true;
        }

    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || numOfTickets>=ticketsLimit
                || totalEstimate+ bugReport.getEstimate()>capacity
                || bugReport.isCompleted()){
            return false;
        }
        else{
            this.addTicket(bugReport);
            return true;
        }
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(this.tickets, numOfTickets);
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }
}
