package dao.Sequencers;

public class AppUserSequencer {
    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        AppUserSequencer.currentId = currentId;
    }
}
