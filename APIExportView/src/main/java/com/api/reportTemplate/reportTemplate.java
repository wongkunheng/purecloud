/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.reportTemplate;

import com.mypurecloud.sdk.v2.model.SelectedColumns;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kh.wong
 */
public class reportTemplate {

    private Map<Integer, String> reportColumns;

    public reportTemplate() {
        this.reportColumns = reportColumns;
    }

    public reportTemplate(int reportNum) {
        setReportTemplate(reportNum);
    }

    public static void main(String args[]) {
        AgentPerformanceSummary ss = new AgentPerformanceSummary();
    }

    public void setReportTemplate(int reportNum) {
        switch (reportNum) {
            case 1:
                AgentPerformanceSummary report1 = new AgentPerformanceSummary();
                this.reportColumns = report1.getReportColumns();
                break;
            case 2:
                AgentStatusSummary report2 = new AgentStatusSummary();
                this.reportColumns = report2.getReportColumns();
                break;
            case 3:
                FlowPerformanceSummary report3 = new FlowPerformanceSummary();
                this.reportColumns = report3.getReportColumns();
                break;
            case 4:
                InteractionView report4 = new InteractionView();
                this.reportColumns = report4.getReportColumns();
                break;
            case 5:
                Queue30mins report5 = new Queue30mins();
                this.reportColumns = report5.getReportColumns();
                break;
            case 6:
                QueuePerformanceSummary report6 = new QueuePerformanceSummary();
                this.reportColumns = report6.getReportColumns();
                break;
            case 7:
                ScheduledCallbacks report7 = new ScheduledCallbacks();
                this.reportColumns = report7.getReportColumns();
                break;
            case 8:
                AgentStatusSummary report8 = new AgentStatusSummary();
                this.reportColumns = report8.getReportColumns();
                break;

        }

    }

    public Map<Integer, String> getReportTemplate() {
        return this.reportColumns;
    }
    
    public List<SelectedColumns> getColumnList(){
          List<SelectedColumns> selectedColumnList = new ArrayList();
          reportColumns.entrySet().forEach(column -> {
              selectedColumnList.add(new SelectedColumns().columnName(column.getValue()).columnOrder(column.getKey()));

        });
          
          return selectedColumnList;
    }
}

class AgentPerformanceSummary {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "agent_performance_view_agent_id");
        columnMap.put(2, "agent_performance_view_agent_name");
        columnMap.put(3, "agent_performance_view_reports_to");
        columnMap.put(4, "agent_performance_view_answered");
        columnMap.put(5, "agent_performance_view_handle");
        columnMap.put(6, "agent_performance_view_average_handle");
        columnMap.put(7, "agent_performance_view_average_dialing");
        columnMap.put(8, "agent_performance_view_average_contacting");
        columnMap.put(9, "agent_performance_view_total_handle");
        columnMap.put(10, "agent_performance_view_total_talk");
        columnMap.put(11, "agent_performance_view_total_hold");
        columnMap.put(12, "agent_performance_view_total_acw");
        columnMap.put(13, "agent_performance_view_total_dialing");
        columnMap.put(14, "agent_performance_view_total_contacting");
        columnMap.put(15, "agent_performance_view_held");
        columnMap.put(16, "agent_performance_view_transferred");
        columnMap.put(17, "agent_performance_view_outbound");
        columnMap.put(18, "agent_performance_view_not_responding");
        columnMap.put(19, "agent_performance_view_alert");
        columnMap.put(20, "agent_performance_view_monitor");
        columnMap.put(21, "agent_performance_view_min_acw");
        columnMap.put(22, "agent_performance_view_max_acw");
        columnMap.put(23, "agent_performance_view_blind_transfer");
        columnMap.put(24, "agent_performance_view_consult_transfer");
        columnMap.put(25, "agent_performance_view_standard_used_count");
        columnMap.put(26, "agent_performance_view_manual_used_count");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class AgentStatusSummary {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "agent_performance_view_agent_id");
        columnMap.put(2, "agent_performance_view_agent_name");
        columnMap.put(3, "agent_status_view_department");
        columnMap.put(4, "agent_status_view_login");
        columnMap.put(5, "agent_status_on_queue");
        columnMap.put(6, "agent_status_idle");
        columnMap.put(7, "agent_status_not_responding");
        columnMap.put(8, "agent_status_interacting");
        columnMap.put(9, "agent_status_communicating");
        columnMap.put(10, "agent_status_off_queue");
        columnMap.put(11, "agent_status_available");
        columnMap.put(12, "agent_status_busy");
        columnMap.put(13, "agent_status_away");
        columnMap.put(14, "agent_status_break");
        columnMap.put(15, "agent_status_meal");
        columnMap.put(16, "agent_status_meal");
        columnMap.put(17, "agent_status_system_away");
        columnMap.put(18, "agent_status_meeting");
        columnMap.put(19, "agent_status_view_occupancy");
        columnMap.put(20, "agent_status_training");
        columnMap.put(21, "agent_status_view_login");
        columnMap.put(22, "agent_status_view_logout");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class FlowPerformanceSummary {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "flow_performance_view_type");
        columnMap.put(2, "flow_performance_view_entries");
        columnMap.put(3, "flow_performance_view_total_flow");
        columnMap.put(4, "flow_performance_view_average_flow");
        columnMap.put(5, "flow_performance_view_disconnect");
        columnMap.put(6, "flow_performance_view_disconnect_rate");
        columnMap.put(7, "flow_performance_view_total_disconnect");
        columnMap.put(8, "flow_performance_view_average_disconnect");
        columnMap.put(9, "flow_performance_view_flow_disconnect");
        columnMap.put(10, "flow_performance_view_flow_disconnect_rate");
        columnMap.put(11, "flow_performance_view_system_error_disconnect");
        columnMap.put(12, "flow_performance_view_system_error_disconnect_rate");
        columnMap.put(13, "flow_performance_view_customer_disconnect");
        columnMap.put(14, "flow_performance_view_customer_disconnect_rate");
        columnMap.put(15, "flow_performance_view_customer_short_disconnect");
        columnMap.put(16, "flow_performance_view_customer_short_disconnect_rate");
        columnMap.put(17, "flow_performance_view_average_exit");
        columnMap.put(18, "flow_performance_view_acd_exit");
        columnMap.put(19, "flow_performance_view_acd_exit_rate");
        columnMap.put(20, "flow_performance_view_flow_exit");
        columnMap.put(21, "flow_performance_view_flow_exit_rate");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class InteractionView {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "flow_performance_view_type");
        columnMap.put(2, "flow_performance_view_entries");
        columnMap.put(3, "flow_performance_view_total_flow");
        columnMap.put(4, "flow_performance_view_average_flow");
        columnMap.put(5, "flow_performance_view_disconnect");
        columnMap.put(6, "flow_performance_view_disconnect_rate");
        columnMap.put(7, "flow_performance_view_total_disconnect");
        columnMap.put(8, "flow_performance_view_average_disconnect");
        columnMap.put(9, "flow_performance_view_flow_disconnect");
        columnMap.put(10, "flow_performance_view_flow_disconnect_rate");
        columnMap.put(11, "flow_performance_view_system_error_disconnect");
        columnMap.put(12, "flow_performance_view_system_error_disconnect_rate");
        columnMap.put(13, "flow_performance_view_customer_disconnect");
        columnMap.put(14, "flow_performance_view_customer_disconnect_rate");
        columnMap.put(15, "flow_performance_view_customer_short_disconnect");
        columnMap.put(16, "flow_performance_view_customer_short_disconnect_rate");
        columnMap.put(17, "flow_performance_view_average_exit");
        columnMap.put(18, "flow_performance_view_acd_exit");
        columnMap.put(19, "flow_performance_view_acd_exit_rate");
        columnMap.put(20, "flow_performance_view_flow_exit");
        columnMap.put(21, "flow_performance_view_flow_exit_rate");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class Queue30mins {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "queue_performance_view_offer");
        columnMap.put(2, "queue_performance_view_answer");
        columnMap.put(3, "queue_performance_view_answer_percent");
        columnMap.put(4, "queue_performance_view_abandon");
        columnMap.put(5, "queue_performance_view_abandon_percent");
        columnMap.put(6, "queue_performance_view_outbound");
        columnMap.put(7, "queue_performance_view_flow_out");
        columnMap.put(8, "queue_performance_view_connect");
        columnMap.put(9, "queue_performance_view_asa");
        columnMap.put(10, "queue_performance_view_service_level_percent");
        columnMap.put(11, "queue_performance_view_service_level_target_percent");
        columnMap.put(12, "queue_performance_view_wait_average");
        columnMap.put(13, "queue_performance_view_average_abandon");
        columnMap.put(14, "queue_performance_view_handle");
        columnMap.put(15, "queue_performance_view_handle_average");
        columnMap.put(16, "queue_performance_view_talk_average");
        columnMap.put(17, "queue_performance_view_hold_average");
        columnMap.put(18, "queue_performance_view_acw_average");
        columnMap.put(19, "queue_performance_view_average_dialing");
        columnMap.put(20, "queue_performance_view_total_contacting");
        columnMap.put(21, "queue_performance_view_total_wait");
        columnMap.put(22, "queue_performance_view_total_abandon");
        columnMap.put(23, "queue_performance_view_handle_total");
        columnMap.put(24, "queue_performance_view_talk_total");
        columnMap.put(25, "queue_performance_view_hold_total");
        columnMap.put(26, "queue_performance_view_acw_total");
        columnMap.put(27, "queue_performance_view_total_dialing");
        columnMap.put(28, "queue_performance_view_total_contacting");
        columnMap.put(29, "queue_performance_view_hold");
        columnMap.put(30, "queue_performance_view_transfer");
        columnMap.put(31, "queue_performance_view_blind_transfer");
        columnMap.put(32, "queue_performance_view_consult");
        columnMap.put(33, "queue_performance_view_consult_transfer");
        columnMap.put(34, "queue_performance_view_media_count_inbound");
        columnMap.put(35, "queue_performance_view_transfer_percent");
        columnMap.put(36, "queue_performance_view_abandon_max");
        columnMap.put(37, "queue_performance_view_abandon_min");
        columnMap.put(38, "queue_performance_view_wait_max");
        columnMap.put(39, "queue_performance_view_wait_min");
        columnMap.put(40, "queue_performance_view_talk_max");
        columnMap.put(41, "queue_performance_view_talk_min");
        columnMap.put(42, "queue_performance_view_hold_max");
        columnMap.put(43, "queue_performance_view_hold_min");
        columnMap.put(44, "queue_performance_view_acw_max");
        columnMap.put(45, "queue_performance_view_acw_min");
        columnMap.put(46, "queue_performance_view_noversla");
        columnMap.put(47, "queue_performance_view_met_sla");
        columnMap.put(48, "queue_performance_view_short_abandon");
        columnMap.put(49, "queue_performance_view_short_abandon_percent");
        columnMap.put(50, "queue_performance_view_abandon_no_short");
        columnMap.put(51, "queue_performance_view_abandon_no_short_percent");
        columnMap.put(52, "queue_performance_view_outbound_attempted");
        columnMap.put(53, "queue_performance_view_error");
        columnMap.put(54, "queue_performance_view_service_level_standalone");
        columnMap.put(55, "queue_performance_view_service_level_target_standalone");
        columnMap.put(56, "queue_performance_view_contacting_count");
        columnMap.put(57, "queue_performance_view_dialing_count");
        columnMap.put(58, "queue_performance_view_avg_acw_handled");
        columnMap.put(59, "queue_performance_view_avg_hold_handled");
        columnMap.put(60, "queue_performance_view_last_requested_count");
        columnMap.put(61, "queue_performance_view_last_requested_rate");
        columnMap.put(62, "queue_performance_view_last_used_count");
        columnMap.put(63, "queue_performance_view_last_used_rate");
        columnMap.put(64, "queue_performance_view_manual_used_count");
        columnMap.put(65, "queue_performance_view_manual_used_rate");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class QueuePerformanceSummary {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "queue_performance_view_offer");
        columnMap.put(2, "queue_performance_view_answer");
        columnMap.put(3, "queue_performance_view_answer_percent");
        columnMap.put(4, "queue_performance_view_abandon");
        columnMap.put(5, "queue_performance_view_abandon_percent");
        columnMap.put(6, "queue_performance_view_outbound");
        columnMap.put(7, "queue_performance_view_flow_out");
        columnMap.put(8, "queue_performance_view_connect");
        columnMap.put(9, "queue_performance_view_asa");
        columnMap.put(10, "queue_performance_view_service_level_percent");
        columnMap.put(11, "queue_performance_view_service_level_target_percent");
        columnMap.put(12, "queue_performance_view_wait_average");
        columnMap.put(13, "queue_performance_view_average_abandon");
        columnMap.put(14, "queue_performance_view_handle");
        columnMap.put(15, "queue_performance_view_handle_average");
        columnMap.put(16, "queue_performance_view_talk_average");
        columnMap.put(17, "queue_performance_view_hold_average");
        columnMap.put(18, "queue_performance_view_acw_average");
        columnMap.put(19, "queue_performance_view_average_dialing");
        columnMap.put(20, "queue_performance_view_total_contacting");
        columnMap.put(21, "queue_performance_view_total_wait");
        columnMap.put(22, "queue_performance_view_total_abandon");
        columnMap.put(23, "queue_performance_view_handle_total");
        columnMap.put(24, "queue_performance_view_talk_total");
        columnMap.put(25, "queue_performance_view_hold_total");
        columnMap.put(26, "queue_performance_view_acw_total");
        columnMap.put(27, "queue_performance_view_total_dialing");
        columnMap.put(28, "queue_performance_view_total_contacting");
        columnMap.put(29, "queue_performance_view_hold");
        columnMap.put(30, "queue_performance_view_transfer");
        columnMap.put(31, "queue_performance_view_blind_transfer");
        columnMap.put(32, "queue_performance_view_consult");
        columnMap.put(33, "queue_performance_view_consult_transfer");
        columnMap.put(34, "queue_performance_view_media_count_inbound");
        columnMap.put(35, "queue_performance_view_transfer_percent");
        columnMap.put(36, "queue_performance_view_abandon_max");
        columnMap.put(37, "queue_performance_view_abandon_min");
        columnMap.put(38, "queue_performance_view_wait_max");
        columnMap.put(39, "queue_performance_view_wait_min");
        columnMap.put(40, "queue_performance_view_talk_max");
        columnMap.put(41, "queue_performance_view_talk_min");
        columnMap.put(42, "queue_performance_view_hold_max");
        columnMap.put(43, "queue_performance_view_hold_min");
        columnMap.put(44, "queue_performance_view_acw_max");
        columnMap.put(45, "queue_performance_view_acw_min");
        columnMap.put(46, "queue_performance_view_noversla");
        columnMap.put(47, "queue_performance_view_met_sla");
        columnMap.put(48, "queue_performance_view_short_abandon");
        columnMap.put(49, "queue_performance_view_short_abandon_percent");
        columnMap.put(50, "queue_performance_view_abandon_no_short");
        columnMap.put(51, "queue_performance_view_abandon_no_short_percent");
        columnMap.put(52, "queue_performance_view_outbound_attempted");
        columnMap.put(53, "queue_performance_view_error");
        columnMap.put(54, "queue_performance_view_service_level_standalone");
        columnMap.put(55, "queue_performance_view_service_level_target_standalone");
        columnMap.put(56, "queue_performance_view_contacting_count");
        columnMap.put(57, "queue_performance_view_dialing_count");
        columnMap.put(58, "queue_performance_view_avg_acw_handled");
        columnMap.put(59, "queue_performance_view_avg_hold_handled");
        columnMap.put(60, "queue_performance_view_last_requested_count");
        columnMap.put(61, "queue_performance_view_last_requested_rate");
        columnMap.put(62, "queue_performance_view_last_used_count");
        columnMap.put(63, "queue_performance_view_last_used_rate");
        columnMap.put(64, "queue_performance_view_manual_used_count");
        columnMap.put(65, "queue_performance_view_manual_used_rate");
        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class ScheduledCallbacks {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "scheduled_callbacks_view_callback_numbers");
        columnMap.put(2, "scheduled_callbacks_view_conversation_start");
        columnMap.put(3, "scheduled_callbacks_view_scheduled_time");
        columnMap.put(4, "scheduled_callbacks_view_queue");
        columnMap.put(5, "scheduled_callbacks_view_campaign");
        columnMap.put(6, "scheduled_callbacks_view_divisions");
        columnMap.put(7, "scheduled_callbacks_view_queue_divisions");
        columnMap.put(8, "scheduled_callbacks_view_campaign_division");
        columnMap.put(9, "scheduled_callbacks_view_skills");
        columnMap.put(10, "scheduled_callbacks_view_languages");
        columnMap.put(11, "scheduled_callbacks_view_conversation_id");
        columnMap.put(12, "scheduled_callbacks_view_duration");
        columnMap.put(13, "scheduled_callbacks_view_ani");
        columnMap.put(14, "scheduled_callbacks_view_external_tag");
        columnMap.put(15, "scheduled_callbacks_view_agent_owner");

        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
}

class WrapUpPerformance {

    private final Map<Integer, String> columnListOrder = initMap();

    private static Map<Integer, String> initMap() {
        Map<Integer, String> columnMap = new HashMap<>();
        columnMap.put(1, "scheduled_callbacks_view_callback_numbers");
        columnMap.put(2, "scheduled_callbacks_view_conversation_start");
        columnMap.put(3, "scheduled_callbacks_view_scheduled_time");
        columnMap.put(4, "scheduled_callbacks_view_queue");
        columnMap.put(5, "scheduled_callbacks_view_campaign");
        columnMap.put(6, "wrapup_performance_view_total_talk");
        columnMap.put(7, "wrapup_performance_view_total_hold");
        columnMap.put(8, "wrapup_performance_view_total_acw");
        columnMap.put(9, "wrapup_performance_view_handle");
        columnMap.put(10, "wrapup_performance_view_hold");
        columnMap.put(11, "wrapup_performance_view_percent_handle");
        columnMap.put(12, "wrapup_performance_view_percent_total_handle");
        columnMap.put(13, "wrapup_performance_view_total_talk_percentage");

        return Collections.unmodifiableMap(columnMap);
    }

    public Map<Integer, String> getReportColumns() {
        return columnListOrder;
    }
    
     

}
