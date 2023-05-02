package feature.sealedClasses;

public sealed class LoanAccount extends Account permits HomeloanAccount, AutoloanAccount {
}
