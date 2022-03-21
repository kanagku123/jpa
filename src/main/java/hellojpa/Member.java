package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id@GeneratedValue
    private Long id;

    @Column(name ="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }


    /* @Column(name = "TEAM_ID")
    private Long teamId;
*/
}
