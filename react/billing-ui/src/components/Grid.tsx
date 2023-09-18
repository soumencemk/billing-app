import DataTable from "react-data-table-component";

const ExpandedComponent = ({ data }) => (
  <pre>{JSON.stringify(data, null, 2)}</pre>
);

interface GridProps {
  columns: [];
  data: [];
}

function Grid({ columns, data }: GridProps) {
  return (
    <div>
      <DataTable
        className="shadow border"
        columns={columns}
        data={data}
        pagination
        highlightOnHover
        pointerOnHover
        fixedHeader
        expandableRows
        expandableRowsComponent={ExpandedComponent}        
      />
    </div>
  );
}

export default Grid;
