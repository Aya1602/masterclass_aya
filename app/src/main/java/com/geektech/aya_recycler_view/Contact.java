package com.geektech.aya_recycler_view;

public class Contact {
    private String name;
    private int avatarResoursId;

    public Contact(String name, int avatarResoursId) {
        this.name = name;
        this.avatarResoursId = avatarResoursId;
    }

    public String getName() {
        return name;
    }

    public int getAvatarResoursId() {
        return avatarResoursId;
    }
}
