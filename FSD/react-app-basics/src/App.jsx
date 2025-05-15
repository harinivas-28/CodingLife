import './App.css'
import Greetings from './components/Greetings'
import { useEffect, useState } from 'react'

function App() {
  const [count, setCount] = useState(0)
  const [data, setData] = useState([])

  useEffect(() => {}, [count])
  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('https://jsonplaceholder.typicode.com/users')
      setData(await response.json())
    }
    fetchData()
  }, [])

  return (
    <>
      <Greetings name="John" /><br />
      <Greetings name="Jane" /><br />
      <Greetings name="Doe" /><br />
      <div>
        <p>Count: {count}</p>
        <button onClick={() => setCount(count + 1)}>Increase</button>
        <button onClick={() => setCount(count - 1)}>Decrease</button>
        <button onClick={() => setCount(0)}>Reset</button>
      </div>
      <br/>
      <div>
        <table border={1} cellPadding={5} cellSpacing={0}>
          <caption>Users List</caption>
          <thead>
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Company Name</th>
            </tr>
          </thead>
          <tbody>
            {data.map((user) => (
              <tr key={user.id}>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>{user.company.name}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  )
}

export default App
