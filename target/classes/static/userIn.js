function login(event){
      event.preventDefault();
	name=document.getElementById('name').value;
	key=document.getElementById('key').value;
	fetch('aust/api/user', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        id:name,
        password:key
    })
   }).then(response => {
        if (response.ok) {
                document.getElementById('loginpage').style.setProperty('display','flex');
		window.location.href = "customer.html";} 
    })
.catch(error => {
    alert('Error:', error);
});
}
function loginpage(){
	document.getElementById('loginpage').style.setProperty('display','flex');
}
document.getElementById('loginform').addEventListener('submit',login);

