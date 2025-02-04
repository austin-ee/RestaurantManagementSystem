/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function fetchData(op) {
	     method='GET'; 
		 if(op=='available'){url='aust/api/table';}
		 else{url='aust/api/user';}
         document.getElementById('display').style.setProperty('display','block');
	 fetch(url,{method:method,headers:{'Content-Type':'application/json'}}) // Make an AJAX request to your server-side script
        .then(response => response.json())
        .then(data => {
		 alert(data[0].status);
            displayData(data,op);
        })
        .catch(error => alert('Error fetching data:', error));
}

function displayData(data,op) {
	const container = document.getElementById('dataTable');
    container.innerHTML = ''; // Clear previous content

    if (data.length === 0) {
        container.innerHTML = '<p>No data available.</p>';
        return;
    }

    // Create a table to display the data
    const table = document.createElement('table');
    table.classList.add('table');

    // Create table headers
    const headers = Object.keys(data[0]);
    const thead = document.createElement('thead');
    const headerRow = document.createElement('tr');
    
	    const tih = document.createElement('th');
        tih.textContent = 'Sno';
        headerRow.appendChild(tih);
		
    headers.forEach(header => {
        const th = document.createElement('th');
        th.textContent = header;
        headerRow.appendChild(th);
    });
    
    thead.appendChild(headerRow);
    table.appendChild(thead);
    //Create table body
    const tbody = document.createElement('tbody');
	var i=1;
    data.forEach(item => {
        const row = document.createElement('tr');
		  //populating Sno
		  const tid = document.createElement('td');
		  tid.textContent=i;
		  row.appendChild(tid);
		  
        headers.forEach(header => {
            const td = document.createElement('td');
            td.textContent = item[header];
            row.appendChild(td);
        });
		i+=1;
		if(op=='available'){
	    row.onclick=()=>{
			document.getElementById('frame').style.setProperty('display','block');
			document.getElementById('tval').innerText=item['tableno'];
			document.getElementById('cval').innerText=item['chairs'];
			
		}}
        tbody.appendChild(row);
    });
    
    table.appendChild(tbody);
    container.appendChild(table);
}
   function reserveDisplay(){
	   document.getElementById('frame').style.setProperty('display','none');
	   document.getElementById('display').style.setProperty('display','none');
	   document.getElementById('container').style.setProperty('display','flex');
	   document.getElementById('tableNo').value=document.getElementById('tval').innerText;
	   document.getElementById('guests').value=document.getElementById('cval').innerText;
	   
   }
function saveData(event){
	// event.preventDefault();
	 alert("Reservation successful");
	 url='aust/api/reserve';
	 alert(document.getElementById('date').value+"time:"+document.getElementById('time').value);
	 data={
		 table:document.getElementById('tableNo').value,
		 date:document.getElementById('date').value,
		 time:document.getElementById('time').value,
		 guests:document.getElementById('guests').value
	 };
	 fetch(url,{method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(data)}) // Make an AJAX request to your server-side script
        .then(response => {
		 alert("response");
        })
        .catch(error => alert('Error fetching data:', error));
	document.getElementById('container').style.setProperty('display','none');
}
