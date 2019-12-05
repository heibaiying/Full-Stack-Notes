package com.heibaiying.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Business implements Observable {

	private List<Observer> observerList = new ArrayList<>();

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer observer : observerList) {
			observer.receive(message);
		}
	}
}
