package Entity;

import java.util.Objects;

public class UserChannelList {

    private long id;
    private boolean is_favorite;
    private long id_user_fk;
    private long id_channel_fk;

    public UserChannelList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return is_favorite;
    }

    public void setFavorite(boolean favorite) {
        is_favorite = favorite;
    }

    public long getIdUserFk() {
        return id_user_fk;
    }

    public void setIdUserFk(long idUserFk) {
        this.id_user_fk = idUserFk;
    }

    public long getIdChannelFk() {
        return id_channel_fk;
    }

    public void setIdChannelFk(long idChannelFk) {
        this.id_channel_fk = idChannelFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChannelList that = (UserChannelList) o;
        return id == that.id && is_favorite== that.is_favorite && id_user_fk== that.id_user_fk && id_channel_fk == that.id_channel_fk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, is_favorite, id_user_fk, id_channel_fk);
    }

    @Override
    public String toString() {
        return "UserChannelList{" +
                "id=" + id +
                ", isFavorite=" + is_favorite +
                ", idUserFk=" + id_user_fk +
                ", idChannelFk=" + id_channel_fk +
                '}';
    }
}