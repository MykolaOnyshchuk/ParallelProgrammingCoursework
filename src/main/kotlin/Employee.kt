class Employee (var name: String, var surname: String, var sex: String,
                var age: Int, var height: Double, var weight: Double,
                var company: String, var hierarchyLevel: String, var profession: String,
                var experienceInCurrentPosition: Int, var experienceInCurrentCompany: Int, var salary: Int) {
    override fun toString(): String {
        return "Employee(name='$name', surname='$surname', sex='$sex'," +
                " age='$age', height=$height, weight=$weight, " +
                "company='$company', hierarchyLevel='$hierarchyLevel', profession='$profession', " +
                "experienceInCurrentPosition=$experienceInCurrentPosition, experienceInCurrentCompany=$experienceInCurrentCompany, salary=$salary)"
    }
}