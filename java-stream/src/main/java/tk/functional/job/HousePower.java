package tk.functional.job;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.opencsv.bean.CsvToBeanBuilder;

public class HousePower {

    public static void main(String[] args) throws FileNotFoundException {
//         CSVReader reader = new CSVReader(new FileReader("household_power_consumption.csv"))){
//            List<String[]> r = reader.readAll();
//            r.forEach( x -> System.out.println(Arrays.toString(x)));

        List<PowerConsumption> list = new CsvToBeanBuilder(new FileReader("household_power_consumption2.csv"))
                .withType(PowerConsumption.class)
                .build()
                .parse();

        List<ModifyConsumption> modifyConsumptions = new ArrayList<>();
        list.forEach(x -> {
            ModifyConsumption modifyConsumption = new ModifyConsumption();
            modifyConsumption.setUseDate(x.getUseDate());
            modifyConsumption.setGlobalActivePower(Double.parseDouble(x.getGlobalActivePower()));
            modifyConsumption.setGlobalReactivePower(Double.parseDouble(x.getGlobalReactivePower()));
            modifyConsumption.setVoltage(Double.parseDouble(x.getVoltage()));
            modifyConsumption.setGlobalIntensity(Double.parseDouble(x.getGlobalIntensity()));
            modifyConsumptions.add(modifyConsumption);
        });

        long start = System.currentTimeMillis();
        List<ModifyConsumption> activePowerisOver5 = modifyConsumptions.stream()
                .filter(x -> x.getGlobalActivePower() > 5)
                //.peek(x -> System.out.println(x.getUseDate()))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms, " + activePowerisOver5);
        System.out.println(activePowerisOver5.size());

        //filter, sorted 테스트
        start = System.currentTimeMillis();
        List<ModifyConsumption> activePowerisOver6 = modifyConsumptions.stream()
                .filter(x -> x.getGlobalActivePower() > 5)
                .sorted((u1, u2) -> u1.getGlobalActivePower().compareTo(u2.getGlobalActivePower()))
                //.peek(x -> System.out.println(x.getUseDate()))
                .collect(Collectors.toList());
        end = System.currentTimeMillis();
        System.out.println(end - start + "ms, " + activePowerisOver6);
        System.out.println(activePowerisOver6.size());


        //groupingBy
        start = System.currentTimeMillis();
        Map<Long, List<ModifyConsumption>> collect = modifyConsumptions.stream()
                .filter(x -> x.getGlobalActivePower() > 5)
                .collect(Collectors.groupingBy(x -> Math.round((double) x.getGlobalActivePower()),
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        end = System.currentTimeMillis();
        System.out.println(end - start + "ms, " + collect);
        System.out.println(collect.get(7l));
        System.out.println(collect.size());

//        modifyConsumptions.forEach(System.out::println);

    }

}
