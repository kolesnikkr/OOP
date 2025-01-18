import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class Tariff {
    private final String name;
    private final double monthlyFee;
    private final int clientCount;

    public Tariff(String name, double monthlyFee, int clientCount) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.clientCount = clientCount;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getClientCount() {
        return clientCount;
    }

    public abstract void describeTariff();
}

class BasicTariff extends Tariff {
    public BasicTariff(String name, double monthlyFee, int clientCount) {
        super(name, monthlyFee, clientCount);
    }

    @Override
    public void describeTariff() {
        System.out.println("Базовий тариф: " + getName() + ", Щомісячна плата: " + getMonthlyFee());
    }
}

class PremiumTariff extends Tariff {
    private final double internationalCallMinutes;

    public PremiumTariff(String name, double monthlyFee, int clientCount, double internationalCallMinutes) {
        super(name, monthlyFee, clientCount);
        this.internationalCallMinutes = internationalCallMinutes;
    }

    @Override
    public void describeTariff() {
        System.out.println("Преміальний тариф: " + getName() + ", Щомісячна плата: " + getMonthlyFee() + ", Хвилини міжнародних розмов: " + internationalCallMinutes);
    }
}

class FamilyTariff extends Tariff {
    private final int maxFamilyMembers;

    public FamilyTariff(String name, double monthlyFee, int clientCount, int maxFamilyMembers) {
        super(name, monthlyFee, clientCount);
        this.maxFamilyMembers = maxFamilyMembers;
    }

    @Override
    public void describeTariff() {
        System.out.println("Сімейний тариф: " + getName() + ", Щомісячна плата: " + getMonthlyFee() + ", Максимальна кількість членів сім'ї: " + maxFamilyMembers);
    }
}

class TariffManager {
    private final List<Tariff> tariffs;

    public TariffManager() {
        tariffs = new ArrayList<>();
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public int getTotalClients() {
        int totalClients = 0;
        for (Tariff tariff : tariffs) {
            totalClients += tariff.getClientCount();
        }
        return totalClients;
    }

    public void sortTariffsByMonthlyFee() {
        tariffs.sort(Comparator.comparingDouble(Tariff::getMonthlyFee));
    }

    public List<Tariff> findTariffsInRange(double minFee, double maxFee) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getMonthlyFee() >= minFee && tariff.getMonthlyFee() <= maxFee) {
                result.add(tariff);
            }
        }
        return result;
    }

    public void displayAllTariffs() {
        for (Tariff tariff : tariffs) {
            tariff.describeTariff();
        }
    }
}

public class MobileCompany {
    public static void main(String[] args) {
        TariffManager manager = new TariffManager();

        manager.addTariff(new BasicTariff("Базовий 100", 100.0, 1000));
        manager.addTariff(new PremiumTariff("Преміум 300", 300.0, 500, 100));
        manager.addTariff(new FamilyTariff("Сімейний 200", 200.0, 700, 4));

        System.out.println("Усі тарифи:");
        manager.displayAllTariffs();

        System.out.println("Усі кліенти: " + manager.getTotalClients());

        manager.sortTariffsByMonthlyFee();
        System.out.println("Тарифи відсортовані за щомісячною платою:");
        manager.displayAllTariffs();

        double minFee = 150.0, maxFee = 250.0;
        System.out.println("Тарифи в діапазоні " + minFee + " грн" + " - " + maxFee + " грн:");
        List<Tariff> tariffsInRange = manager.findTariffsInRange(minFee, maxFee);
        for (Tariff tariff : tariffsInRange) {
            tariff.describeTariff();
        }
    }
}
