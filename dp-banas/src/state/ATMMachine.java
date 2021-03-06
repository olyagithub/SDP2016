package state;

import lombok.Data;

@Data
public class ATMMachine {

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState atmOutOfMoney;

    ATMState atmState;

    int cashInMachine;
    boolean correctPinEntered;

    {
        correctPinEntered = false;
        cashInMachine = 2000;
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

    }

    public ATMMachine() {
        if (cashInMachine < 0) {
            atmState = atmOutOfMoney;
        }
    }

    void setATMState(ATMState newATMState) {

        atmState = newATMState;

    }

    public void setCashInMachine(int newCashInMachine) {

        cashInMachine = newCashInMachine;

    }

    public void insertCard() {

        atmState.insertCard();

    }

    public void ejectCard() {

        atmState.ejectCard();

    }

    public void requestCash(int cashToWithdraw) {

        atmState.requestCash(cashToWithdraw);

    }

    public void insertPin(int pinEntered) {

        atmState.insertPin(pinEntered);

    }

    public ATMState getYesCardState() {
        return hasCard;
    }

    public ATMState getNoCardState() {
        return noCard;
    }

    public ATMState getHasPin() {
        return hasCorrectPin;
    }

    public ATMState getNoCashState() {
        return atmOutOfMoney;
    }

}