import { fromEvent } from 'rxjs';
import { ajax } from 'rxjs/ajax';
import { map } from 'rxjs/operators';

const showDataBtn = document.getElementById('show-data-btn');
const deleteRowBtn = document.getElementById('delete-row-btn');
const dataTable = document.getElementById('data-table');
const tableBody = dataTable.querySelector('tbody');


fromEvent(showDataBtn, 'click')
  .subscribe(() => {
    ajax.getJSON('data.json')
    .subscribe(data => {
        tableBody.innerHTML = '';
        console.log(data);
        console.log(typeof data);

        var rows = "";
        for (let i = 0; i < data.length; i++) {
            const row = data[i];
            rows += `
            <tr>
              <td>${row.serviceID}</td>
              <td>${row.workType}</td>
              <td>${row.workDescription}</td>
              <td>${row.isExpired}</td>
              <td>${row.dispatcherID}</td>
            </tr>
          `;
          console.log(typeof rows);
      dataTable.querySelector('tbody').innerHTML = rows;
        }
        
    });
  });

fromEvent(deleteRowBtn, 'click')
  .subscribe(() => {
        const rows = dataTable.querySelectorAll('tbody tr');
        if (rows.length > 0) {
        const lastRow = rows[rows.length - 1];
        lastRow.parentNode.removeChild(lastRow);
        }
});

console.log('Entered app');