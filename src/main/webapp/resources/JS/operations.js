const operationType = document.getElementsByTagName("select")[0];
const category = document.getElementsByTagName("div")[1];
const subcategory = document.getElementsByTagName("div")[2];





    if (operationType.value === "add_funds") {
        category.classList.add("hidden");
        subcategory.classList.add("hidden");
    }

    if(operationType.value === "buy_sth"){
        document.getElementsByTagName("select")[1].children[0].classList.add("hidden");
        document.getElementsByTagName("select")[2].children[0].classList.add("hidden");
    }


operationType.addEventListener("change", () => {

    document.getElementsByTagName("select")[1].value = "2";
    document.getElementsByTagName("select")[2].value = "2";

    if (operationType.value === "add_funds") {
        category.classList.add("hidden");
        subcategory.classList.add("hidden");
        document.getElementsByTagName("select")[1].children[0].classList.add("hidden");
        document.getElementsByTagName("select")[2].children[0].classList.add("hidden");
        document.getElementsByTagName("select")[1].value = "1";
        document.getElementsByTagName("select")[2].value = "1";
    } else {
        category.classList.remove("hidden");
        subcategory.classList.remove("hidden");
    }


});