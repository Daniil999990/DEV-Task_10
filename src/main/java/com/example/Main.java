package com.example;

import com.example.service.TicketCrudService;
import com.example.utils.FlywayMigration;

public class Main {
    public static void main(String[] args) {
        new FlywayMigration().migration();
        TicketCrudService ticketService = new TicketCrudService();
        ticketService.updateById(9L,"Daniil", "Mars", "Venera");

    }
}