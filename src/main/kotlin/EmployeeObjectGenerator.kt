import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.random.Random

class EmployeeArrayGenerator {
    var sexes: ArrayList<String> = arrayListOf("man", "woman")
    var names: ArrayList<Pair<String, String>> = arrayListOf("Anastasia" to sexes.get(1), "Andrew" to sexes.get(0),
        "Arthur" to sexes.get(0), "Anna" to sexes.get(1), "Dmytro" to sexes.get(0), "Halyna" to sexes.get(1),
        "Ihor" to sexes.get(0), "Inna" to sexes.get(1), "Ivan" to sexes.get(0), "Kateryna" to sexes.get(1),
        "Maksym" to sexes.get(0), "Maria" to sexes.get(1), "Maryna" to sexes.get(1), "Mykhailo" to sexes.get(0),
        "Mykola" to sexes.get(0), "Mykyta" to sexes.get(0), "Natalia" to sexes.get(1), "Oleksandr" to sexes.get(0),
        "Oleksandra" to sexes.get(1), "Olha" to sexes.get(1), "Pavlo" to sexes.get(0), "Petro" to sexes.get(0),
        "Ruslan" to sexes.get(0), "Svitlana" to sexes.get(1), "Valentyna" to sexes.get(1), "Viktor" to sexes.get(0),
        "Victoria" to sexes.get(1), "Volodymyr" to sexes.get(0))

    var surnames: ArrayList<String> = arrayListOf("Melnyk", "Shevchenko", "Boyko", "Kovalenko", "Bondarenko",
        "Tkachenko", "Kovalchuk", "Kravchenko", "Oliynyk", "Shevchuk", "Koval", "Polishchuk", "Bondar", "Tkachuk", "Moroz",
        "Marchenko", "Lysenko", "Rudenko", "Savchenko", "Petrenko", "Kravchuk", "Klymenko", "Pavlenko", "Savchuk", "Kuzmenko",
        "Shvets", "Havrylyuk", "Kharchenko", "Ponomarenko", "Melnychuk", "Vasylenko", "Mazur", "Khomenko")

    var companies: ArrayList<String> = arrayListOf("Genesis", "Ciklum", "Intellias",
        "Luxoft", "SoftServe", "GlobalLogic", "Sigma Software", "ELEKS", "EPAM")

    var hierarchyLevels: ArrayList<String> = arrayListOf("Trainee/Intern", "Junior", "Medium", "Senior", "Lead")

    var professions: ArrayList<String> = arrayListOf("Tester (QA)", "Front-end Developer", "Back-end Developer",
        "Mobile Developer", "Game Developer", "Embedded Developer", "System Administrator", "Business Analyst",
        "Designer", "Project Manager", "Product Manager", "HR", "PR manager")

    fun generateArray(size: Int): Array<Employee?> {
        var arrayOfObj: Array<Employee?> = arrayOfNulls<Employee>(size)

        for (i in arrayOfObj.indices) {
            var surname: String = surnames.get((0..32).random())
            var nameRand: Int = (0..27).random()
            var (name: String, sex: String) = names.get(nameRand)

            var height: Double
            var weight: Double
            if (sex == "woman") {
                height = BigDecimal(Random.nextDouble(155.0, 190.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
                weight = BigDecimal(Random.nextDouble(45.0, 100.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            } else {
                height = BigDecimal(Random.nextDouble(165.0, 200.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
                weight = BigDecimal(Random.nextDouble(65.0, 120.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            }
            var age: Int = (18..40).random()
            var company: String = companies[(0..8).random()]
            var hierarchyLevel: String = hierarchyLevels[(0..4).random()]
            var profession: String = professions[(0..12).random()]
            var experienceInCurrentPosition: Int = 0
            var salary: Int = 0
            if (hierarchyLevel == "Trainee/Intern") {
                experienceInCurrentPosition = (0..6).random()
                salary = (0..800).random()
            } else if (hierarchyLevel == "Junior") {
                experienceInCurrentPosition = (3..24).random()
                salary = (500..2000).random()
            } else if (hierarchyLevel == "Middle") {
                experienceInCurrentPosition = (18..42).random()
                salary = (1800..5000).random()
            } else if (hierarchyLevel == "Senior") {
                experienceInCurrentPosition = (36..72).random()
                salary = (2500..6000).random()
            } else if (hierarchyLevel == "Lead") {
                experienceInCurrentPosition = (48..120).random()
                salary = (4000..10000).random()
            }
            var experienceInCurrentCompany: Int = (0..experienceInCurrentPosition).random()

            arrayOfObj[i] = Employee(name, surname, sex, age, height, weight, company,
                hierarchyLevel, profession, experienceInCurrentPosition, experienceInCurrentCompany, salary)
        }
        return arrayOfObj
    }

    fun generateIdenticalElementsArray(size: Int): Array<Employee?> {
        var arrayOfObj: Array<Employee?> = arrayOfNulls<Employee>(size)
        var surname: String = surnames.get((0..32).random())
        var nameRand: Int = (0..27).random()
        var (name: String, sex: String) = names.get(nameRand)
        var height: Double
        var weight: Double
        if (sex == "woman") {
            height = BigDecimal(Random.nextDouble(155.0, 190.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            weight = BigDecimal(Random.nextDouble(45.0, 100.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        } else {
            height = BigDecimal(Random.nextDouble(165.0, 200.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
            weight = BigDecimal(Random.nextDouble(65.0, 120.0)).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        }
        var age: Int = (18..40).random()
        var company: String = companies[(0..8).random()]
        var hierarchyLevel: String = hierarchyLevels[(0..4).random()]
        var profession: String = professions[(0..12).random()]
        var experienceInCurrentPosition: Int = 0
        var salary: Int = 0
        if (hierarchyLevel == "Trainee/Intern") {
            experienceInCurrentPosition = (0..6).random()
            salary = (0..800).random()
        } else if (hierarchyLevel == "Junior") {
            experienceInCurrentPosition = (3..24).random()
            salary = (500..2000).random()
        } else if (hierarchyLevel == "Middle") {
            experienceInCurrentPosition = (18..42).random()
            salary = (1800..5000).random()
        } else if (hierarchyLevel == "Senior") {
            experienceInCurrentPosition = (36..72).random()
            salary = (2500..6000).random()
        } else if (hierarchyLevel == "Lead") {
            experienceInCurrentPosition = (48..120).random()
            salary = (4000..10000).random()
        }
        var experienceInCurrentCompany: Int = (0..experienceInCurrentPosition).random()

        for (i in arrayOfObj.indices) {

            arrayOfObj[i] = Employee(name, surname, sex, age, height, weight, company,
                hierarchyLevel, profession, experienceInCurrentPosition, experienceInCurrentCompany, salary)
        }
        return arrayOfObj
    }

}
