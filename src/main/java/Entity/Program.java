package Entity;

import java.sql.Date;
import java.util.Objects;

public class Program {

    private long id;
    private String name;
    private int idChannelFk;
    private int duration;
    private Date datetime;

    public Program() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdChannelFk() {
        return idChannelFk;
    }

    public void setIdChannelFk(int id_channel_fk) {
        this.idChannelFk = id_channel_fk;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id && idChannelFk == program.idChannelFk && duration == program.duration && name.equals(program.name) && datetime.equals(program.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idChannelFk, duration, datetime);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", id_channel_fk=" +idChannelFk +
                ", duration=" + duration +
                ", datetime=" + datetime +
                '}';
    }
}
