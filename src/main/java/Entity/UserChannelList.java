package Entity;

import java.util.Objects;

public class UserChannelList {

    private long id;
    private boolean isFavorite;
    private int idUserFk;
    private int idChannelFk;

    public UserChannelList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getIdUserFk() {
        return idUserFk;
    }

    public void setIdUserFk(int idUserFk) {
        this.idUserFk = idUserFk;
    }

    public int getIdChannelFk() {
        return idChannelFk;
    }

    public void setIdChannelFk(int idChannelFk) {
        this.idChannelFk = idChannelFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChannelList that = (UserChannelList) o;
        return id == that.id && isFavorite == that.isFavorite && idUserFk == that.idUserFk && idChannelFk == that.idChannelFk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isFavorite, idUserFk, idChannelFk);
    }

    @Override
    public String toString() {
        return "UserChannelList{" +
                "id=" + id +
                ", isFavorite=" + isFavorite +
                ", idUserFk=" + idUserFk +
                ", idChannelFk=" + idChannelFk +
                '}';
    }
}