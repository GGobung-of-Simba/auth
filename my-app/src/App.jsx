import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const App = () => {

  return (
    <div className="container mt-3">
        <h1 className="text-center bg-success text-dark bg-opacity-50">LIST</h1>
        <div className="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="/" className="btn btn-secondary">전체</a>
            <a href="/?accept=1" className="btn btn-success">승인</a>
            <a href="/?accept=0" className="btn btn-warning">미승인</a>
            <a href="/input" className="btn btn-primary">추가</a>
        </div>
        <div className="list-group mt-2 text-center">
          <a className="list-group-item m-1 display-6 list-group-item-success" href="/detail">테스트</a>
        </div>
    </div>
  );
}

export default App;