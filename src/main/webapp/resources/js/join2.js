//id, name, pw, email, phone이 필수입력사항
//만약에 입력안했으면 alert창에 name, emial 입력하세 이렇게 뜨게 하기

const idx = document.getElementById('idx');
const idResult = document.getElementById('idResult');
const pw = document.getElementById('pw');
const pwResult = document.getElementById('pwResult');
const pw2 = document.getElementById('pw2');
const pwResult2 = document.getElementById('pwResult2')
const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
const btn = document.getElementById('btn');
const frm = document.getElementById('frm')

let pwCheck=true; //같지 않을 때 true, 같으면 false

//pw와 pw2 가 같은지 검증
pw2.addEventListener('blur', function(){ 
    let message = "PW가 일치 합니다";
    if(pw.value != pw2.value){
        pwCheck = true;
        message = 'PW가 일치하지 않습니다';
        pw2.value='';

    }else {
        pwCheck=false;
    }

    pwResult2.innerHTML = message;

});

//---- 검증이 끝나고 pw를 수정 했을 경우
pw.addEventListener('change', function(){
    pwCheck=true;
    pw2.value='';
    pwResult2.value='';
    pw2.focus();


});

//---- pw 길이 검증 ------------------------------
pw.addEventListener('blur', function(){
    if(pw.value.length<8 || pw.value.length>12){
        pwResult.innerHTML='PW길이 미충족'

    }
});


//---- ID 입력 후 ---------------------------------
idx.addEventListener('blur', function(){
    if(idx.value==''){
        idResult.innerHTML='ID를 입력하세요';

    }
})

//----- 가입 버튼 ----------------------------------
btn.addEventListener("click", function(){

    if(idx.value==''){
        alert('ID를 입력하세요');
        idx.focus();
        return;
    }

    if(pw.value=='' || pw.value.length<8 || pw.value.length>12){
        alert('pw가 정확하지 않습니다');
        pw.focus();
        return;
    }

    if(pwCheck){
        alert('PW가 일치 하지 않습니다');
        pw2.focus();
        return;
    }

    if(name.value==''){
        alert('Name을 입력하세요');
        name.focus();
        return;
    }

    if(phone.value==''){
        alert('Phone을 입력하세요');
        phone.focus();
        return;
    }

    if(email.value==''){
        alert('email를 입력하세요');
        email.focus();
        return;
    }

    frm.submit();

})