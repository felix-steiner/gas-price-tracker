const timeseries = [];
fetch('http://192.168.0.222:8080/gas-prices/chart')
  .then(response => response.json())
  .then(data => {
    data.forEach(gasStation => {
      const prices = [];
      gasStation.gasPriceDTOS.forEach(x => {
        prices.push({x: timestampToDate(x.createdAt), y: x.price});
      });
      timeseries.push({name: gasStation.name, data: prices});
    });
  });

const options = {
  chart: {
    type: 'line',
  },
  series: timeseries,
};

const chart = new ApexCharts(document.getElementById('chart'), options);

chart.render();

function timestampToDate(timestamp) {
  const date = new Date(timestamp);
  return `${date.getDate()}.${date.getMonth()}.${date.getFullYear()} ${date.getHours()}:${date.getMinutes()}`;
}
