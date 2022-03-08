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

const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

let idCheck=false; //check ok : true, check X:false
let pwCheck=false;
let nameCheck=false;
let phoneCheck=false;
let emailCheck=false;

pw.addEventListener("change", function(){
    pwCheck=false;
    pw2.value='';
});

email.addEventListener('blur', function(){
    if(email.value==''){
        emailCheck=false;
    }else{
        emailCheck=true;
    }
})

phone.addEventListener('blur', function(){
    if(phone.value==''){
        phoneCheck=false;
    }else{
        phoneCheck=true;
    }
})

name.addEventListener('blur', function(){
    if(name.value==''){
        nameCheck=false;
    }else{
        nameCheck=true;
    }
})

btn.addEventListener("click", function(){
    if(idCheck && pwCheck&&nameCheck&&phoneCheck&&emailCheck){
        frm.submit();
        //강제 실행
    }else{
        alert("필수요건을 확인하세요.");
    }
});

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