//전역 변수
//
const pw = document.getElementById('pw');
const pwResult = document.getElementById('pwResult');

const idx = document.getElementById('idx');
const idResult = document.getElementById('idResult');

const pw2 = document.getElementById('pw2');
const pw2Result = document.getElementById('pw2Result');

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

let idCheck=false;
let pwCheck=false;

btn.addEventListener("click", function(){
    frm.submit();
    //강제 실행
})

pw2.addEventListener("blur", function(){
    let v1 = pw.value;
    let v2 = pw2.value;
    let msg = "비번이 일치하지 않습니다.";

    if(v1==v2){
        msg="일치";
        pwCheck=true;
    }else{
        pwCheck=false;
    }
    pw2Result.innerHTML=msg;
})

idx.addEventListener("blur", function(){
    let v = idx.value;
    
    if(v==''){
        //혹은 v.length=''도 가능
        idResult.innerHTML="id를 입력하세요"
        idCheck=false;
    }else{
        idCheck=true;
    }
    
});

pw.addEventListener("keyup", function(){
    let length = pw.value.length;
    let message="8글자 입력하세요";

    if(length>=8 && length<=12){
        message = "정상";
    }

    pwResult.innerHTML=message;
});