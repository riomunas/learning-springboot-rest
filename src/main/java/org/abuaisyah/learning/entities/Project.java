package org.abuaisyah.learning.entities;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "uc_project_name", columnNames = {"name"})
})
public class Project {
    @Id
    @Column(name = "sid", nullable = false)
    private UUID sid;

    @Column(name = "name", nullable = false)
    private String name;

    @PastOrPresent
    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_sid", nullable = false)
    private AppUser manager;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_sid")
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public AppUser getManager() {
        return manager;
    }

    public void setManager(AppUser manager) {
        this.manager = manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getSid() {
        return sid;
    }

    public void setSid(UUID sid) {
        this.sid = sid;
    }
}