class ComparatorNameEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.name.compareTo(obj2.name)
    }
}

class ComparatorSurnameEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null)
            throw NullPointerException()
        return obj1.surname.compareTo(obj2.surname)
    }
}

class ComparatorSexEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null)
            throw NullPointerException()
        return obj1.sex.compareTo(obj2.sex)
    }
}

class ComparatorAgeEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.age.compareTo(obj2.age)
    }
}

class ComparatorHeightEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.height.compareTo(obj2.height)
    }
}

class ComparatorWeightEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.weight.compareTo(obj2.weight)
    }
}

class ComparatorCompanyEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.company.compareTo(obj2.company)
    }
}

class ComparatorHierarchyLevelEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        val hierarchyLevelMap = mapOf("Trainee/Intern" to 0, "Junior" to 1, "Medium" to 2, "Senior" to 3, "Lead" to 4)
        return hierarchyLevelMap.getValue<String, Int>(obj2.hierarchyLevel).compareTo(hierarchyLevelMap.getValue<String, Int>(obj1.hierarchyLevel))
    }
}

class ComparatorProfessionEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.profession.compareTo(obj2.profession)
    }
}

class ComparatorExperienceInCurrentPositionEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.experienceInCurrentPosition.compareTo(obj2.experienceInCurrentPosition)
    }
}

class ComparatorExperienceInCurrentCompanyEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.experienceInCurrentCompany.compareTo(obj2.experienceInCurrentCompany)
    }
}

class ComparatorSalaryEmployee: Comparator<Employee>{
    override fun compare(obj1: Employee?, obj2: Employee?): Int {
        if(obj1 == null || obj2 == null){
            throw NullPointerException()
        }
        return obj1.salary.compareTo(obj2.salary)
    }
}