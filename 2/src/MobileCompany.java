import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

abstract class Tariff {
    private String name;
    private double monthlyFee;
    private int numberOfClients;

    public Tariff(String name, double monthlyFee, int numberOfClients) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.numberOfClients = numberOfClients;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "Тариф: " + name + ", Щомісячна плата: " + monthlyFee + " грн, Клієнтів: " + numberOfClients;
    }
}

class BasicTariff extends Tariff {
    private int callMinutes;

    public BasicTariff(String name, double monthlyFee, int numberOfClients, int callMinutes) {
        super(name, monthlyFee, numberOfClients);
        this.callMinutes = callMinutes;
    }

    @Override
    public String getDetails() {
        return "Базовий тариф: " + getName() + ", Хвилин дзвінків: " + callMinutes;
    }
}

class InternetTariff extends Tariff {
    private int dataLimit;

    public InternetTariff(String name, double monthlyFee, int numberOfClients, int dataLimit) {
        super(name, monthlyFee, numberOfClients);
        this.dataLimit = dataLimit;
    }

    @Override
    public String getDetails() {
        return "Інтернет-тариф: " + getName() + ", Ліміт даних: " + dataLimit + " ГБ";
    }
}

class PremiumTariff extends Tariff {
    private boolean includesRoaming;

    public PremiumTariff(String name, double monthlyFee, int numberOfClients, boolean includesRoaming) {
        super(name, monthlyFee, numberOfClients);
        this.includesRoaming = includesRoaming;
    }

    @Override
    public String getDetails() {
        return "Преміальний тариф: " + getName() + ", Роумінг включено: " + (includesRoaming ? "Так" : "Ні");
    }
}

class TariffManager {
    private List<Tariff> tariffs = new ArrayList<>();

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public int getTotalClients() {
        return tariffs.stream().mapToInt(Tariff::getNumberOfClients).sum();
    }

    public void sortTariffsByMonthlyFee() {
        tariffs.sort(Comparator.comparingDouble(Tariff::getMonthlyFee));
    }

    public List<Tariff> findTariffsByPriceRange(double minPrice, double maxPrice) {
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getMonthlyFee() >= minPrice && tariff.getMonthlyFee() <= maxPrice) {
                result.add(tariff);
            }
        }
        return result;
    }

    public void displayTariffs() {
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }
}

class MobileCompany {
    public static void main(String[] args) {
        TariffManager manager = new TariffManager();

        manager.addTariff(new BasicTariff("Базовий-100", 100.0, 500, 300));
        manager.addTariff(new InternetTariff("Інтернет-50", 150.0, 300, 50));
        manager.addTariff(new PremiumTariff("Преміум-Роумінг", 250.0, 150, true));

        System.out.println("Усі тарифи:");
        manager.displayTariffs();

        System.out.println("Загальна кількість клієнтів: " + manager.getTotalClients());

        System.out.println("Тарифи, відсортовані за щомісячною платою:");
        manager.sortTariffsByMonthlyFee();
        manager.displayTariffs();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть мінімальну вартість: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Введіть максимальну вартість: ");
            double maxPrice = scanner.nextDouble();

            List<Tariff> foundTariffs = manager.findTariffsByPriceRange(minPrice, maxPrice);
            System.out.println("Тарифи у діапазоні [" + minPrice + " грн, " + maxPrice + " грн]:");
            if (foundTariffs.isEmpty()) {
                System.out.println("Не знайдено жодного тарифу.");
            } else {
                for (Tariff tariff : foundTariffs) {
                    System.out.println(tariff.getDetails());
                }
            }
        } catch (Exception e) {
            System.out.println(" Будь ласка, введіть числа.");
        } finally {
            scanner.close();
        }
    }
}
