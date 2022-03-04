/**
 * 
 */

const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');
const btn = document.getElementById('btn');

checkAll.addEventListener("click", function(){
    for(c of check){
        c.checked = checkAll.checked;
        
    }
})
 
for(ch of check){
    ch.addEventListener("click", function(){
        // console.log(this.checked);
        // this는 click한 자기자신을 불러오는 거
        // 콘솔창에 checked가 true인지 false인지 나옴.
         
        let final = true;
        //네개 다 체크되어있는거 담아놓는 변수
            for(c of check){
                if(!c.checked){
                    final = false;
                    //if(c.checked!=true --> c 한개라도 != true라면
                    //!c.checked로 간소화할 수 있음. checked가 곧 true니까. 거기에 반대(!)되는걸 말하는거
                    //final에 false 넣는다.
                }
            }
        checkAll.checked=final;
           
    })

    btn.addEventListener("click", function(){
        // let c = true;
    
        // for(ch of check){
        //     if(!ch.checked){
        //         c=false;
        //     }
        // }
    
        if(checkAll.checked){
           location.href="./join";
        }else{
           alert("전체동의하세요");
        }
    });
}
