
        <div class="form-group date">
          <label for="inputEmail3" class="col-sm-2 control-label">Erledigt bis</label>
          <div class="col-sm-2">
            <input class="form-control" data-provide="datepicker" data-date-format="yyyy-mm-dd" pattern="\d{4}-\d{1,2}-\d{1,2}" value="<?php echo date("Y-m-d"); ?>" name="date_end">
          </div>
        </div>


		<script>
          $(document).ready(function(){
            var date_input=$('input[name="date_end"]'); //our date input has the name "date"
            var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
                format: 'yyyy-mm-dd',
                weekStart: 1,
                container: container,
                todayHighlight: true,
                autoclose: true,
                daysOfWeekHighlighted: "1,2,3,4,5",
                calendarWeeks: true,
                language: "de"
            })
          })
        </script>