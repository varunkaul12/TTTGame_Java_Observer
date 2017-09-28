public interface Observable {
    public void notifyListeners();
    public void registerObserver(Observer o);
}
