<div class="shopcart2">
    <button
        type="button"
        class="btn btn-success"
        data-toggle="modal"
        data-target="#myModal"
        >
        <i class="fa fa-shopping-cart"></i>
    </button>
</div>
<div class="modal fade" id="myModal">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Your Shopping Cart</h4>
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Cast</th>
                            <th>Quatity</th>
                            <th>Action</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>IT</td>
                            <td>$1000</td>
                            <td>1</td>
                            <td>2</td>
                            <td>
                                <button type="button" class="btn btn-success">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-dismiss="modal"
                    >
                    Close
                </button>
                <button type="button" class="btn btn-success">Confirm</button>
            </div>
        </div>
    </div>
</div>
