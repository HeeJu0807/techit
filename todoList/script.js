document.addEventListener("DOMContentLoaded", function() {
    // 초기 데이터 설정
    let basicDatas = [
        { id: 1, title: "Todo 1", done: false },
        { id: 2, title: "Todo 2", done: true }
    ];

    const todoItemList = document.getElementById("todo-item-list");
    const inputTask = document.getElementById("inputTask");
    const addBtn = document.getElementById("addBtn");

  

    // 할 일 추가
    function addTodo() {
        // 할 일 입력받음
        const text = inputTask.value;
        if (text !== "") {

            // 할 일 목록에 할 일이 비어있으면 id = 1, 1개 이상이면 id +1
            const newId = basicDatas.length > 0 ? basicDatas[basicDatas.length - 1].id + 1 : 1;
            basicDatas.push({ id: newId, title: text, done: false });
            displayTodoList();
            inputTask.value = "";
        }
    }

    // 할 일 상태 업데이트 
    function updateTodo() {
        displayTodoList();
    }

    // 할 일 삭제 
    function removeTodo() {
        displayTodoList();
    }


    addBtn.addEventListener("click", addTodo);

    // 입력 상자에서 엔터 키 입력으로 할 일 추가
    inputTask.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            addTodo();
        }
    });
});
