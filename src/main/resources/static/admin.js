function toggleMenu(event) {
    event.preventDefault(); // Prevent the default anchor behavior
    const parentLi = event.currentTarget.parentNode; // Get the parent li element

    // Toggle the 'active' class to show/hide the submenu
    parentLi.classList.toggle('active');
}

function fetchData(op){
	let url;
	let method;
	if(op=="employees"){method="Get"; url="aust/api/employee/all";}
    //fetch api
 fetch(url,{Method:method}).
 then(response=>response.json())
 .then(data =>{displayData(data);})
 .catch(error=>alert('Error Fetching Data:'+error));
}

function displayData(data){
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
	    tbody.appendChild(row);
    });
    
    table.appendChild(tbody);
    container.appendChild(table);
}	