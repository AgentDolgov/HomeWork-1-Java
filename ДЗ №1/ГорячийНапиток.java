public class ГорячийНапиток {
    private String name;
    private int volume;

    public ГорячийНапиток(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

public class ГорячийНапитокСТемпературой extends ГорячийНапиток {
    private int температура;

    public ГорячийНапитокСТемпературой(String name, int volume, int температура) {
        super(name, volume);
        this.температура = температура;
    }

    // Геттер и сеттер для температуры

    public int getТемпература() {
        return температура;
    }

    public void setТемпература(int температура) {
        this.температура = температура;
    }
}

public interface ТорговыйАвтомат {
    ГорячийНапиток getProduct(int name, int volume, int temperature);
}

public class ГорячиеНапиткиАвтомат implements ТорговыйАвтомат {
    @Override
    public ГорячийНапиток getProduct(int name, int volume, int temperature) {
        return new ГорячийНапитокСТемпературой(name, volume, temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        ГорячиеНапиткиАвтомат автомат = new ГорячиеНапиткиАвтомат();
        ГорячийНапиток продукт = автомат.getProduct("Чай", 200, 80);

        System.out.println("Название: " + продукт.getName());
        System.out.println("Объем: " + продукт.getVolume());
        if (продукт instanceof ГорячийНапитокСТемпературой) {
            System.out.println("Температура: " + ((ГорячийНапитокСТемпературой) продукт).getТемпература());
        }
    }
}
