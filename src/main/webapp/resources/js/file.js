const fileAdd = document.getElementById("fileAdd");
const fileResult = document.getElementById("fileResult");
const del = document.getElementsByClassName("del");

let count = 0;
let num = 0; //id용도로 사용할 것임.

fileAdd.addEventListener("click", function(){
    
    if(count>4){
        alert('파일은 최대 5개만 첨부 가능합니다.');
        return;
    }
    
    count++;

    let div = document.createElement('div'); //div태그 만들어줘
    div.setAttribute("id", "del"+num);
    //del0, del1, del2 ...가 되겟지

    let file = document.createElement("input");
    file.setAttribute("type", "file");
    file.setAttribute("name", "files");
    
    let button = document.createElement('button');
    button.setAttribute("type", "button");
    button.className="del";
    button.setAttribute("data-num", "del"+num);
    button.innerHTML="delete";
    
    div.append(file);
    div.append(button);

    fileResult.append(div);
    num++;

});

    //클래스는 배열이라 직접 addevent줄수없음
    //그래서 반복문으로 돌리고 하나씩 꺼내서 addevent줘야함
    // for(d of del){
    //     d.addEventListener("click", function(){
    //         console.log("delete click");
    //     })
    //}

    fileResult.addEventListener("click", function(event){
        let cn =event.target;
        
        if(cn.classList.contains('del')){
            //if cn에 'del'이 포함되어있다면
            let delNum = cn.getAttribute("data-num");
            document.getElementById(delNum).remove();
            count--;
        }
    });

    //----
    const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
    const files = document.querySelector("#files");

    //각각의 filenum을 콘솔에 찍어
    files.addEventListener("click", function(event){
        if(event.target.classList.contains("fileDeleteBtn")){
            let check=confirm("delete?");

            if(!check){
                //false=취소
                //취소면 밑에 더 내려가지말고 여기서 메서드 끝내
                return;
            }

            let fileNum = event.target.getAttribute("data-fileNum")
            
            //ajax parameter:fileNum, method=post, 
            //url:fileDelete, qnaController:fileDelete

                let xhttp=new XMLHttpRequest;
                xhttp.open("post", "./fileDelete")
                xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xhttp.send("fileNum="+fileNum);
                xhttp.onreadystatechange=function(){
                    if(this.readyState==4 && this.status==200){
                        console.log(this.responseText)
                        let result = this.responseText.trim();
                        if(result=='1'){
                            console.log("file 삭제");
                            event.target.parentNode.remove();
                        }else{
                            
                        }
                    }
            }
        
    }
    });