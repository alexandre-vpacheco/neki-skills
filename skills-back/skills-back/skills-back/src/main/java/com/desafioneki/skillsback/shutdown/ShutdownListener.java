package com.desafioneki.skillsback.shutdown;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {

    private final JdbcTemplate jdbcTemplate;

    public ShutdownListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        jdbcTemplate.update("DROP TABLE users, skills, users_skills");
    }
}
