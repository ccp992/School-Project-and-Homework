<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Desk1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.lblMenu = New System.Windows.Forms.Label()
        Me.gpBurgers = New System.Windows.Forms.GroupBox()
        Me.chkBacon = New System.Windows.Forms.CheckBox()
        Me.gpBurgers.SuspendLayout()
        Me.SuspendLayout()
        '
        'lblMenu
        '
        Me.lblMenu.AutoSize = True
        Me.lblMenu.Font = New System.Drawing.Font("Times New Roman", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblMenu.Location = New System.Drawing.Point(13, 14)
        Me.lblMenu.Name = "lblMenu"
        Me.lblMenu.Size = New System.Drawing.Size(70, 15)
        Me.lblMenu.TabIndex = 0
        Me.lblMenu.Text = "Food Menu"
        '
        'gpBurgers
        '
        Me.gpBurgers.Controls.Add(Me.chkBacon)
        Me.gpBurgers.Font = New System.Drawing.Font("Times New Roman", 12.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Underline), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.gpBurgers.Location = New System.Drawing.Point(45, 66)
        Me.gpBurgers.Name = "gpBurgers"
        Me.gpBurgers.Size = New System.Drawing.Size(241, 210)
        Me.gpBurgers.TabIndex = 2
        Me.gpBurgers.TabStop = False
        Me.gpBurgers.Text = "Burgers"
        '
        'chkBacon
        '
        Me.chkBacon.AutoSize = True
        Me.chkBacon.Font = New System.Drawing.Font("Times New Roman", 9.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.chkBacon.Location = New System.Drawing.Point(27, 34)
        Me.chkBacon.Name = "chkBacon"
        Me.chkBacon.Size = New System.Drawing.Size(124, 19)
        Me.chkBacon.TabIndex = 0
        Me.chkBacon.Text = "Bacon and American"
        Me.chkBacon.UseVisualStyleBackColor = True
        '
        'Desk1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 14.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(790, 491)
        Me.Controls.Add(Me.gpBurgers)
        Me.Controls.Add(Me.lblMenu)
        Me.Font = New System.Drawing.Font("Times New Roman", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Name = "Desk1"
        Me.Text = "Form2"
        Me.gpBurgers.ResumeLayout(False)
        Me.gpBurgers.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lblMenu As System.Windows.Forms.Label
    Friend WithEvents gpBurgers As System.Windows.Forms.GroupBox
    Friend WithEvents chkBacon As System.Windows.Forms.CheckBox
End Class
