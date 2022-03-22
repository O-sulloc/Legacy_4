const reply = document.querySelector("#reply");
//#하고 id명
//query여러개면 queryselectorall
const writer = document.getElementById("writer");
const num = document.getElementById("num");
const contents  = document.querySelector("#contents");
//id로 가져와도 되고 queryselect해도 되고
const replyResult = document.querySelector("#replyResult");
// 혹은 const del = document.getElementsByClassName("del");
const del = document.querySelectorAll(".del");

//------------delete
replyResult.addEventListener("click", function(event){
    if(event.target.classList.contains('del')){
        //클래스명이 'del'이라는 contains을 포함하고 있다면 아래 실행해
        
        let replyNum=event.target.getAttribute("data-num");
        
        //url "/noticeReply/delete", method=post, parameter=replyNum
        //ajax로 요청보내고 controller ㅁㅔ서드도 만들고
        //메서드명은 delete
        const xhttp = new XMLHttpRequest();
        xhttp.open("post", "../noticeReply/delete")
        xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhttp.send("replyNum="+replyNum);
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                if(this.responseText.trim()=='1'){
                    alert('삭제 성공');
                    getList();
                }else{
                    alert('삭제 실패');
                }
            }
        }


    }

});

//--------------
getList();

function getList(){
    //함수 이름이 result인
    const xhttp2 = new XMLHttpRequest();
    //메서드는 겟메서드
    //파라미터 글번호 45를 수동으로
    //파라미터 못하겟으면 주소만 보내

    xhttp2.open("GET", "../noticeReply/list?num="+num.value)

    xhttp2.send();
    xhttp2.onreadystatechange = function(){
        //상태가 변한다면 이런 function함수를 실행해라
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText);
            replyResult.innerHTML=this.responseText.trim();
        }
    }
}

reply.addEventListener("click", function(){

    //console에 찍어보기
    console.log(writer.value);
    console.log(num.value);
    console.log(contents.value);

    // js에서 요청 객체 생성(준비)
    // ajax를 보내기 위해서 객체를 준비하는 거임
    const xhttp = new XMLHttpRequest();

    //요청 정보 입력
    //add?parameter 작성해야되는데 post는 여기에 작성 안함.
    xhttp.open("POST", "../noticeReply/add");

    //요청 header 정보
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    //요청 전송
    //그래서 여기에 파라미터 작성
    //send("파라미터 네임=value&파라미터 이름=value...")
    xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);
    
    //응답 처리
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
            let result = this.responseText.trim();
            //trim 앞뒤 공백제거하는 메서드
            if(result=='1'){
                alert('댓글이 등록되었습니다.');
                getList();
            }else{
                alert('댓글 등록 실패');
            }
        }
    }

});