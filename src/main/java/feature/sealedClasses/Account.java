package feature.sealedClasses;

public sealed class Account permits CurrentAccount, SavingAccount, LoanAccount {
}
