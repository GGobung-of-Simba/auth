import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const Detail = () => {
  return (
    <div className="container mt-3">
        <h1 className="text-center bg-success text-dark bg-opacity-50">DETAIL</h1>
        <form action="/edit" method="post">
            <input type="hidden" className="form-control" id="no" name="no" value="0" />
            <div className="mb-3 mt-3">
              <label htmlFor="title" className="form-label">Title:</label>
              <input type="text" className="form-control" id="title" placeholder="Enter title" name="title" required autoComplete="off" defaultValue="title" />
            </div>
            <div className="mb-3">
              <label htmlFor="content" className="form-label">Content:</label>
              <input type="text" className="form-control" id="content" placeholder="Enter content" name="content" autoComplete="off" defaultValue="content" />
            </div>
            <div className="d-grid gap-2 d-md-flex justify-content-md-end">
                <button className="btn btn-primary me-md-2" type="submit">수정</button>
                <a className="btn btn-success" href="/accept">승인</a>
                <a className="btn btn-warning" href="/accept">미승인</a>
                <a className="btn btn-secondary" href="/">취소</a>
            </div>
        </form>
    </div>
  );
}

export default Detail;