package by.it.kisel.JD03_02.crud;

public class Rooms {
    private int ID;
    private int RoomCount;
    private int Quality;
    private int PriceForDay;
    private String Conditioner;
    private String Description;

    public Rooms() {
    }

    public Rooms(int ID, int roomCount, int quality, int priceForDay, String conditioner, String description) {
        this.ID = ID;
        RoomCount = roomCount;
        Quality = quality;
        PriceForDay = priceForDay;
        Conditioner = conditioner;
        Description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoomCount() {
        return RoomCount;
    }

    public void setRoomCount(int roomCount) {
        RoomCount = roomCount;
    }

    public int getQuality() {
        return Quality;
    }

    public void setQuality(int quality) {
        Quality = quality;
    }

    public int getPriceForDay() {
        return PriceForDay;
    }

    public void setPriceForDay(int priceForDay) {
        PriceForDay = priceForDay;
    }

    public String getConditioner() {
        return Conditioner;
    }

    public void setConditioner(String conditioner) {
        Conditioner = conditioner;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rooms rooms = (Rooms) o;

        if (ID != rooms.ID) return false;
        if (RoomCount != rooms.RoomCount) return false;
        if (Quality != rooms.Quality) return false;
        if (PriceForDay != rooms.PriceForDay) return false;
        if (Conditioner != null ? !Conditioner.equals(rooms.Conditioner) : rooms.Conditioner != null) return false;
        return Description != null ? Description.equals(rooms.Description) : rooms.Description == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + RoomCount;
        result = 31 * result + Quality;
        result = 31 * result + PriceForDay;
        result = 31 * result + (Conditioner != null ? Conditioner.hashCode() : 0);
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        return result;
    }
}
