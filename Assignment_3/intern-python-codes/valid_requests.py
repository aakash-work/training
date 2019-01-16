import requests
response = requests.get('http://jsonplaceholder.typicode.com/todos')
response
<Response [200]>
response = requests.get('http://127.0.0.1:9001/test/t1/mediaiq')
response
<Response [200]>
response = requests.get('http://127.0.0.1:9001/test/t1/t2/ashu')
response
<Response [404]>
